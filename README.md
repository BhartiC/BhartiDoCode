## How the flow works (simple explanation)

1. **Browse movies**: `/api/movies` returns movies and supports filters like city, language, and genre.
2. **Scenario 1 - Browse theaters and timings**: `/api/movies/{movieId}/theaters?city=Delhi&date=2026-01-25` shows which theaters are playing the movie in a city on a chosen date.
3. **Scenario 2 - Book seats**: `/api/bookings` accepts a theater, showtime, and preferred seats, then returns a confirmation.

All data is **in-memory** for now, so it’s easy to understand and replace later with a database.
The booking flow uses **transactional DB logic** on top of an in-memory H2 database to demonstrate safe seat locking.
