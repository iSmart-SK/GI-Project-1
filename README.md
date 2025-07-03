## 🌱 Seed Donation API Endpoints

| HTTP Method | Endpoint                            | Action                                       |
|-------------|-------------------------------------|----------------------------------------------|
| POST        | `/api/seeds`                        | Create a new seed donation                   |
| GET         | `/api/seeds`                        | Retrieve all seed donations                  |
| GET         | `/api/seeds/{id}`                   | Retrieve a seed donation by ID               |
| PUT         | `/api/seeds/{id}`                   | Fully update a seed donation by ID           |
| PATCH       | `/api/seeds/{id}`                   | Partially update a seed donation by ID       |
| DELETE      | `/api/seeds/{id}`                   | Delete a seed donation by ID                 |
| GET         | `/api/seeds/location/{location}`    | Get all donations by drop location           |
| GET         | `/api/seeds/type/{type}`            | Get all donations by seed type               |


## 🌱 Seed Donor API Endpoints

| Method   | Endpoint            | Description                      | Request Body             | Response            |
| -------- | ------------------- | -------------------------------- | ------------------------ | ------------------- |
| `GET`    | `/api/donor`      | Get all seed donors              | –                        | List of seed donors |
| `GET`    | `/api/donor/{id}` | Get seed donor by ID             | –                        | Single seed donor   |
| `POST`   | `/api/donor`      | Create a new seed donor          | JSON (name, email, etc.) | Created seed donor  |
| `PUT`    | `/api/donor/{id}` | Update existing seed donor by ID | JSON (name, email, etc.) | Updated seed donor  |
| `DELETE` | `/api/donor/{id}` | Delete seed donor by ID          | –                        | Success message     |
