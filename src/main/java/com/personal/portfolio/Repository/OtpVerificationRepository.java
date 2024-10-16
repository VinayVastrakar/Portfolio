package com.personal.portfolio.Repository;

import com.personal.portfolio.Model.OtpVerification;
import com.personal.portfolio.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OtpVerificationRepository extends JpaRepository<OtpVerification, Long> {
    Optional<OtpVerification> findByOtpAndUser(String otp, Users user);


    @Query(value = "SELECT * FROM otp_verification o WHERE o.user_id = :userId AND o.is_verified = true ORDER BY o.expiration_time DESC LIMIT 1", nativeQuery = true)
    Optional<OtpVerification> findTopByUserAndIsVerifiedTrue(@Param("userId") Long userId);

    String findByUserAndIsVerifiedTrue(Users users);


    List<OtpVerification> findByUser(Users user);

    void deleteByUser(Users user);

    Optional<OtpVerification> findTopByUserAndIsVerifiedFalse(Users user);

    @Query("SELECT o FROM OtpVerification o WHERE o.expirationTime < :now")
    List<OtpVerification> findExpiredOtps(@Param("now") LocalDateTime now);

    @Query("SELECT o FROM OtpVerification o WHERE o.user = :user AND o.isVerified = false ORDER BY o.expirationTime DESC")
    Optional<OtpVerification> findTopByUserAndIsVerifiedFalseOrderByExpirationTimeDesc(@Param("user") Users user);

    @Query("select o FROM OtpVerification o WHERE o.user = :user")
    List<OtpVerification> findAllOtpsByUser(@Param("user") Users user);
}
