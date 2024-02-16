package dk.favrholdt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "package")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "tracking_number", nullable = false, unique = true)
    private String trackingNumber;

    @Column(name = "sender_name", nullable = false, length = 10)
    private String senderName = "GLS";

    @Column(name = "receiver_name", nullable = false, length = 20)
    private String receiverName;

    @Column(name = "delivery_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Column(name = "last_updated", nullable = false)
    private String lastUpdated;

    @PreUpdate
    @PrePersist
    public void setLastUpdated() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        lastUpdated = LocalDateTime.now().format(dtf);
    }

    enum DeliveryStatus {
        PENDING,
        IN_TRANSIT,
        DELIVERED
    }
}