ALTER TABLE topic
	ADD COLUMN code_example VARCHAR NOT NULL,
	ADD COLUMN code_explanation VARCHAR NOT NULL;

DROP TABLE code_example