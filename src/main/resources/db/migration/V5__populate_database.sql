-- Insert categories
INSERT INTO categories (name) VALUES
('Fruits'),
('Vegetables'),
('Dairy'),
('Bakery'),
('Beverages'),
('Snacks');

-- Insert products
INSERT INTO products (name, price, description, category_id) VALUES
 ('Bananas', 40.00, 'Fresh ripe bananas, sold per dozen', 1),
 ('Apples', 180.00, 'Kashmiri red apples, 1 kg pack', 1),
 ('Tomatoes', 60.00, 'Fresh red tomatoes, 1 kg', 2),
 ('Potatoes', 35.00, 'Farm-fresh potatoes, 1 kg', 2),
 ('Amul Milk (1L)', 52.00, 'Toned milk, 1 litre packet', 3),
 ('Mother Dairy Yogurt (500g)', 65.00, 'Fresh plain yogurt, 500 grams tub', 3),
 ('Whole Wheat Bread', 45.00, 'Soft & healthy whole wheat bread loaf', 4),
 ('Britannia Rusk', 60.00, 'Crunchy wheat rusks, 300 grams pack', 4),
 ('Coca Cola (2L)', 110.00, 'Refreshing soft drink, 2 litre bottle', 5),
 ('Lays Classic Salted', 20.00, 'Potato chips, 52 grams pack', 6);
