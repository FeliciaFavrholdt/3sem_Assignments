package dk.favrholdt;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "package")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tracking_number", nullable = false, unique = true)
    private String trackingNumber;

    @Column(name = "sender_name", nullable = false)
    private String senderName;

    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Column(name = "delivery_status", nullable = false)
    private DeliveryStatus deliveryStatus;

    @Column(name = "delivery_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private String deliveryDate;

    @Column(name = "delivery_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private String deliveryTime;

    @PrePersist
    protected void onCreate() {
        deliveryDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        deliveryTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @PreUpdate
    protected void onUpdate() {
        deliveryDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        deliveryTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public Package(String trackingNumber, String senderName, String receiverName, DeliveryStatus deliveryStatus, String deliveryDate, String deliveryTime) {
        this.trackingNumber = trackingNumber;
        this.senderName = "GLS"; // senderName is hardcoded to "GLS"
        this.receiverName = receiverName;
        this.deliveryStatus = DeliveryStatus.values()[0]; // deliveryStatus is hardcoded to "PENDING"
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", senderName='" + senderName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", deliveryStatus=" + deliveryStatus +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                '}';
    }
}

enum DeliveryStatus {
    PENDING,
    IN_TRANSIT,
    DELIVERED
}