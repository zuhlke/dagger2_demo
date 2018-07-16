#!/bin/bash
LOOPS=$1
count=0
sum=0

function doAverage() {
    FILE=$1
    TIME=$(grep -A1 '<td>Total Build Time</td>' $FILE | grep -o '<td class="numeric">.*</td>' | sed "s/<td class=\"numeric\">//" | sed "s/s<\/td>//")
    ((count++))
    sum=$(echo $sum+$TIME | bc)
}

rm -r build/reports/profile/*.html

for n in {1..$LOOPS}; do ./gradlew build --profile; done

for (( c=1; c<$LOOPS; c++ ))
do
    echo "Build $c"
    ./gradlew build --profile
done

for f in build/reports/profile/*.html ; do doAverage $f ; done

echo "scale=3; ($sum / $count)/1" | bc 
