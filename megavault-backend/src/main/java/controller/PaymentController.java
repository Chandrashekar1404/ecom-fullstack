package controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.Utils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payment/razorpay")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class PaymentController {

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    /**
     * Create a real Razorpay Order.
     *
     * Endpoint:
     * POST /api/payment/razorpay/create-order
     */
    @PostMapping("/create-order")
    public ResponseEntity<Map<String, Object>> createRazorpayOrder(
            @RequestBody Map<String, Object> data) {

        Map<String, Object> response = new LinkedHashMap<>();

        try {
            double amount = Double.parseDouble(
                    data.getOrDefault("amount", "100").toString()
            );

            String currency = data
                    .getOrDefault("currency", "INR")
                    .toString();

            String receipt = data
                    .getOrDefault(
                            "receipt",
                            "rcpt_" + System.currentTimeMillis()
                    )
                    .toString();

            long amountInPaise = Math.round(amount * 100);

            RazorpayClient razorpayClient =
                    new RazorpayClient(
                            razorpayKeyId,
                            razorpayKeySecret
                    );

            JSONObject orderRequest = new JSONObject();

            orderRequest.put("amount", amountInPaise);
            orderRequest.put("currency", currency);
            orderRequest.put("receipt", receipt);

            Order razorpayOrder =
                    razorpayClient.orders.create(orderRequest);

            String orderId = razorpayOrder.get("id");

            response.put("status", "CREATED");
            response.put("orderId", orderId);
            response.put("amount", amountInPaise);
            response.put("currency", currency);
            response.put("receipt", receipt);
            response.put("keyId", razorpayKeyId);
            response.put(
                    "message",
                    "Razorpay Order created successfully!"
            );

            System.out.println(
                    "💳 [RAZORPAY] Real Order Created: "
                            + orderId
                            + " | Amount: ₹"
                            + amount
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            e.printStackTrace();

            response.put("status", "ERROR");
            response.put(
                    "message",
                    "Failed to create Razorpay Order: "
                            + e.getMessage()
            );

            return ResponseEntity
                    .internalServerError()
                    .body(response);
        }
    }

    /**
     * Verify Razorpay Payment Signature.
     *
     * Endpoint:
     * POST /api/payment/razorpay/verify-signature
     */
    @PostMapping("/verify-signature")
    public ResponseEntity<Map<String, Object>> verifyPaymentSignature(
            @RequestBody Map<String, Object> data) {

        Map<String, Object> response = new LinkedHashMap<>();

        try {

            String razorpayOrderId =
                    (String) data.get("razorpayOrderId");

            String razorpayPaymentId =
                    (String) data.get("razorpayPaymentId");

            String razorpaySignature =
                    (String) data.get("razorpaySignature");

            if (razorpayOrderId == null
                    || razorpayPaymentId == null
                    || razorpaySignature == null) {

                response.put("status", "FAILED");
                response.put(
                        "message",
                        "Missing Razorpay payment verification data."
                );

                return ResponseEntity
                        .badRequest()
                        .body(response);
            }

            JSONObject attributes = new JSONObject();

            attributes.put(
                    "razorpay_order_id",
                    razorpayOrderId
            );

            attributes.put(
                    "razorpay_payment_id",
                    razorpayPaymentId
            );

            attributes.put(
                    "razorpay_signature",
                    razorpaySignature
            );

            boolean isValid = Utils.verifyPaymentSignature(
                    attributes,
                    razorpayKeySecret
            );

            if (!isValid) {

                response.put("status", "FAILED");
                response.put(
                        "message",
                        "Invalid Razorpay payment signature."
                );

                return ResponseEntity
                        .badRequest()
                        .body(response);
            }

            response.put("status", "SUCCESS");
            response.put(
                    "message",
                    "Razorpay payment verified successfully."
            );
            response.put(
                    "razorpayOrderId",
                    razorpayOrderId
            );
            response.put(
                    "razorpayPaymentId",
                    razorpayPaymentId
            );

            System.out.println(
                    "✅ [RAZORPAY] Payment signature verified: "
                            + razorpayPaymentId
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            e.printStackTrace();

            response.put("status", "ERROR");
            response.put(
                    "message",
                    "Payment verification failed: "
                            + e.getMessage()
            );

            return ResponseEntity
                    .internalServerError()
                    .body(response);
        }
    }
}