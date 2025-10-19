# Debian Bookworm base; multi-arch (arm64/amd64/etc.)
FROM docker.io/library/postgres:16-bookworm

# Install PostGIS matching PostgreSQL 16
# (postgis + postgresql-16-postgis-3 provide the server extension and SQL files)
RUN apt-get update && \
    apt-get install -y --no-install-recommends postgis postgresql-16-postgis-3 && \
    rm -rf /var/lib/apt/lists/*

# (Optional) Automatically enable PostGIS in the default DB at init time
# Any *.sql under /docker-entrypoint-initdb.d/ runs ON FIRST INIT (not on restarts)
COPY 00-enable-postgis.sql /docker-entrypoint-initdb.d/
