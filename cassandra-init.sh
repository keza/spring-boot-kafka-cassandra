CQL="DROP keyspace userspace;
CREATE KEYSPACE userspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;
CREATE TABLE IF NOT EXISTS userspace.user (cratedat bigint, email text, followerlist list<uuid>, id uuid, name text, phonenumber text, surname text, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS userspace.userfollowers (followerlist list<uuid>, id uuid, userid uuid, PRIMARY KEY (id));"

until echo $CQL | cqlsh; do
  echo "cqlsh: Cassandra is unavailable to initialize - will retry later"
  sleep 2
done &

exec /docker-entrypoint.sh "$@"