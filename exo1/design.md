# Design Proposal

## Data

Address : id, number, street, city, region, zipcode, country, additional_information, is_billing
Customer_to_Address : address_id, customer_id
Customer : id, username (email), name, password, phone_number
Purchase : client_id, products, address_id, billing_address_id ...
Purchase_to_Product : purchase_id, product_id
Products : name, price, ...
Post_office : address_id, contact_number, contact_email