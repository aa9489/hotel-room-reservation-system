# Reservation system architecture

```mermaid
graph LR
Browser --> SpringMVC
SpringMVC --> Services
Services --> JPA
JPA --> H2[(H2 local)]
JPA --> PG[(PostgreSQL production)]
```
