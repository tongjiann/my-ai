create extension  if not exists vector;
create extension  if not exists hstore;
create extension  if not exists "uuid-ossp";

DROP TABLE IF EXISTS vector_store;
CREATE TABLE vector_store(
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    content TEXT,
    metadata JSON,
    embedding VECTOR(384)
);

create INDEX on vector_store using  hnsw(embedding vector_cosine_ops);
