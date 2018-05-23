import psycopg2

def get_connection():
    conn = psycopg2.connect("dbname='justlearnit' user='justlearnit' password = 'jlit' host='127.0.0.1' port='5432'")
    return conn
