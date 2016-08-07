DECLARE
  command VARCHAR2(255);
BEGIN
  FOR x IN
  (SELECT
     table_name
   FROM user_tables ) LOOP
    command := 'drop table ' || x.table_name || ' cascade constraints';
    EXECUTE IMMEDIATE command;
  END LOOP;
  FOR x IN
  (SELECT
     sequence_name
   FROM user_sequences) LOOP
    command := 'drop sequence ' || x.sequence_name;
    EXECUTE IMMEDIATE command;
  END LOOP;
END;
/