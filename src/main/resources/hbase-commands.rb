export HBASE_HOME
$HBASE_HOME/bin/start-hbase.sh

## Creating a table "Patient" with the column Families (Personal and Medical)
create 'Patient','Personal','Medical'

## Inserting a record into the table
put 'Patient','001','Personal:pname','datadotz'
put 'Patient','002','Personal:pname','saravanan'
put 'Patient','002','Personal:s2','saravanan'
put 'Patient','003','Personal:pname','gowtham'
put 'Patient','004','Personal:pname','amudhan'
put 'Patient','005','Personal:pname','alex'
put 'Patient','002','Personal:age','24'
put 'Patient','105','Personal:pname','alex'
put 'Patient','202','Personal:age','24'
put 'Patient','202','Personal:s1','24'
put 'Patient','202','Personal:s1','25'


## Scan/select all the data from the table
scan 'Patient'

## Scan/select with rowkey
get 'Patient','002'

## Retrieve more versions
scan 'Patient',{VERSIONS => 3}

## delete a specific column from rowkey
delete 'Patient','002','Personal:pname'


## delete entire rowkey details
deleteall 'Patient','001'

## Disable table
disable 'Patient'

## Enable table
enable 'Patient'

## Alter table details
alter 'Patient',{NAME=>'Personal',VERSIONS=>5}

## Retrieve more versions
scan 'Patient',{VERSIONS => 3}

## Describe the table
describe 'Patient'

## drop the table. Table should be disabled to drop.
drop 'Patient'

## drop the column family from the table
alter 'Patient',{NAME=>'Medical',METHOD=>'delete'}

## Execute the hbase commands from file
bin/hbase shell list_of_commands.txt

## Show all the filters
show_filters

## Example of keyonlyfilter
## This filter does not take any arguments. It returns only the key component of each key-value.
scan 'Patient',{ FILTER => "KeyOnlyFilter()"}

## FirstKeyOnlyFilter
## This filter doesntt take any arguments. It returns only the first key-value from each row.
scan 'Patient',{ FILTER => "FirstKeyOnlyFilter()"}

## prefixfilter:
## This filter takes one argument  a prefix of a row key. It returns only those key-values present in a row that starts with the specified row prefix
scan 'Patient', {FILTER => "(PrefixFilter ('002'))"}


## ColumnPrefixFilter
## This filter takes one argument  a column prefix. It returns only those key-values present in a column that starts with the specified column prefix. The column prefix must be of the form qualifier
scan 'Patient', {FILTER => "(PrefixFilter ('002')) AND ColumnPrefixFilter('a')"}

## MultipleColumnPrefixFilter
## This filter takes a list of column prefixes. It returns key-values that are present in a column that starts with any of the specified column prefixes. Each of the column prefixes must be of the form qualifier
scan 'Patient',{FILTER => "MultipleColumnPrefixFilter('p','a')"}


## ColumnCountGetFilter
## This filter takes one argument as limit. It returns the first limit number of columns in the table.
scan 'Patient',{FILTER => "ColumnCountGetFilter(1)"}

## PageFilter
## This filter takes one argument  a page size. It returns page size number of rows from the table.
scan 'Patient',{FILTER => "PageFilter(1)"}

## InclusiveStopFilter
## This filter takes one argument  a row key on which to stop scanning. It returns all key-values present in rows up to and including the specified row.


scan 'Patient',{FILTER => "InclusiveStopFilter('003')"}

## Family Filter(Qualifier Filter)
## This filter takes a compare operator and a comparator. It compares each qualifier name with the comparator using the compare operator and if the comparison returns true, it returns all the key-values in that column.

scan 'Patient',{ FILTER => "QualifierFilter(=,'binary:age')"}

## ValueFilter
## This filter takes a compare operator and a comparator. It compares each value with the comparator using the compare operator and if the comparison returns true, it returns that key-value.

scan 'Patient', { COLUMNS => 'Personal:pname', LIMIT => 4, FILTER => "ValueFilter( =, 'binaryprefix:data' )" }

## Selecting columns and introducing limit

scan 'Patient', { COLUMNS => 'Personal:pname', LIMIT => 2}







































