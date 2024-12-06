#!/bin/bash
# build the kotlin file and run it
# 2024.12.06 by dralee
file=$1
name=${file%%.*}
out_dir=out

out_file=$out_dir/$name.jar
echo $out_file
mkdir -p $out_dir

echo build $file for $name
#konanc $file -o $name
kotlinc $file -include-runtime -d $out_file

# run it
echo ------------------------------------
java -jar $out_file

