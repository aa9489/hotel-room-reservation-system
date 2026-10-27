# Test report

Run date: 2026-10-27 (Asia/Calcutta)

## Automated build and tests

Command executed from the project directory:

```powershell
mvn clean package
```

Outcome: **BUILD SUCCESS**. The build compiled with the local Microsoft JDK `25.0.4.1` using `maven.compiler.release=21`, ran the full test suite, built `target/hotel-room-reservation-system-1.0.0.jar`, and Spring Boot repackaged it as an executable JAR.

Surefire result: **10 tests, 0 failures, 0 errors, 0 skipped**.

- `ReservationApiIntegrationTest`: 4 Spring Boot / MockMvc tests. Covered app context and landing page, seeded room listing, customer registration and duplicate/invalid input, booking total, overlap response, cancellation and lookup, rebooking after cancellation, invalid dates, guest capacity, and half-open availability boundaries.
- `ReservationServiceTest`: 6 service tests. Covered duplicate email, server-side total/reference creation, overlap and capacity rejection, date validation, cancellation state, and availability query forwarding.

## Packaged application smoke check

The executable JAR was started locally on port 18081. HTTP checks returned `200` for `/` and `/api/rooms`, found six seeded rooms and six available sample rooms, created a three-night booking for `$357` at `$119/night`, then verified both the cancel response and reference lookup returned `CANCELLED`.

The test suite uses H2 for repeatable local verification. No live PostgreSQL deployment or public hosting account was available or used, so public deployment remains a user-side step described in `README.md`.

