package dk.favrholdt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;


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

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tracking_number", nullable = false, unique = true)
    private String trackingNumber;

    @Column(name = "sender_name", nullable = false, length = 10)
    private String senderName = "GLS";

    @Column(name = "receiver_name", nullable = false, length = 20)
    private String receiverName;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status", nullable = false)
    private DeliveryStatus deliveryStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(name = "last_updated", nullable = false)
    private String lastUpdated;

    @OneToMany(mappedBy = "aPackage", cascade = CascadeType.PERSIST)
    private Set<Shipment> shipmentSet;

    @PreUpdate
    @PrePersist
    public void setLastUpdated() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        lastUpdated = LocalDateTime.now().format(dtf);
    }

    public void addShipment(Shipment shipment) {
        shipmentSet.add(shipment);
    }

    public void removeShipment(Shipment shipment) {
        shipmentSet.remove(shipment);
    }

    public Package(String trackingNumber, String senderName, String receiverName, DeliveryStatus deliveryStatus, String lastUpdated) {
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.deliveryStatus = deliveryStatus;
        this.lastUpdated = lastUpdated;
    }

    public enum DeliveryStatus {
        PENDING,
        IN_TRANSIT,
        DELIVERED
    }
}