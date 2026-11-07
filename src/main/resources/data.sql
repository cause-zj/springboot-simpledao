INSERT INTO demo_item (id, name, create_time, create_by, dr)
SELECT 1, '示例条目', CURRENT_TIMESTAMP, 0, 0
WHERE NOT EXISTS (SELECT 1 FROM demo_item WHERE id = 1);
