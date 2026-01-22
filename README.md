# XYZ Online Movie Booking Platform (Starter)

This is a **basic Spring Boot starter** for an online movie ticket booking platform. It is designed for B2C customers to browse movies by city, language, and genre and book seats in advance with a smooth flow.
## How the flow works (simple explanation)

1. **Browse movies**: `/api/movies` returns movies and supports filters like city, language, and genre.
2. **Scenario 1 - Browse theaters and timings**: `/api/movies/{movieId}/theaters?city=Delhi&date=2026-01-25` shows which theaters are playing the movie in a city on a chosen date.
3. **Scenario 2 - Book seats + payment**: `/api/bookings` accepts a theater, showtime, preferred seats, and payment details, then returns a confirmation with a payment reference.

```bash
curl -X POST http://localhost:8080/api/bookings \
  -H "Content-Type: application/json" \
  -d '{\"showtimeId\": \"show-201\", \"theaterId\": \"theater-01\", \"customerName\": \"Asha\", \"seatNumbers\": [\"A1\", \"A2\"], \"paymentMethod\": \"CARD\", \"amount\": 500.0}'
```
