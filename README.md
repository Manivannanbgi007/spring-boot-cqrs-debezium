Register Debezium Source and Sink Connectors:

Register MySQL Source Connector::
curl -i -X POST http://localhost:8093/connectors/ -H "Content-Type: application/json" -d "@debezium/mysql-source.json"

Register MySQL JDBC Sink Connector:
curl -i -X POST http://localhost:8093/connectors/ -H "Content-Type: application/json" -d "@debezium/mysql-sink.json"


Verify Connector Statuses::

curl -s http://localhost:8093/connectors/mysql-source-connector/status
curl -s http://localhost:8093/connectors/mysql-sink-connector/status

End-to-End Testing
1. Create an Order (Write App)

curl -i -X POST http://localhost:8081/api/orders ^
  -H "Content-Type: application/json" ^
  -d "{\"customerId\":\"CUST-100\",\"productName\":\"MacBook Pro M3\",\"quantity\":1,\"totalPrice\":1999.99}"

2. Query Read Database (Read App)

Fetch immediately from Read Application:

curl -s http://localhost:8082/api/orders/e4f8d2a1-09bc-4a22-b5e1-8f3a93881a29
