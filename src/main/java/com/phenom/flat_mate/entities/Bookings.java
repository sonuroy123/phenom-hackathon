
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Integer interestId;

    @Column(nullable = false)
    private Integer houseId;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Constructors
    public Booking() {
    }

    public Booking(Integer userId, Integer interestId, Integer houseId, LocalDateTime startDate, LocalDateTime endDate) {
        this.userId = userId;
        this.interestId = interestId;
        this.houseId = houseId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}