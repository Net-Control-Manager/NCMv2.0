CREATE INDEX IF NOT EXISTS idx_station_latlong_gist ON station USING GIST (lat_long);
CREATE INDEX IF NOT EXISTS idx_net_start_time ON net(start_time);
CREATE INDEX IF NOT EXISTS idx_net_entry_net ON net_entry(net_id);
