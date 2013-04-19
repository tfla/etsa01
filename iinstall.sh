#! /bin/bash
# Build script for cs_eda016

# Function for determining wether junit and hamcrest should be on
# the classpath. The .java files that need it are in array.
contains() {
	n=$#
    value=${!n}
    for ((i=1; i < $#; i++)){
        if [[ "${!i}" == "${value}" ]]; then
            echo "y"
            return 0
        fi
    }
    echo "n"
    return 1
}

# Check if ./bin/ exists, if not, create it.
dir=./bin
if [ -d $dir ]; then
	echo "$dir exists, proceeding ..."
else
	mkdir $dir
fi

# Function for compiling.
function build() {
if [ -d $1/$2 ]; then
	echo "$1/$2 exists, proceeding ..."
else
	mkdir $1/$2
fi
javac -g -verbose -d $1/$2 .src/*.java

# Select and build a folder.
PS3='Choose a folder to build: '
select folder in "all" $( ls ./src/ ); do
	if [ $folder = "all" ]; then
		for f in $( ls ./src/ ); do
			build $dir $f
		done
	elif [ $folder != "all" ]; then
		build $dir $folder
	fi
	break
done

exit 0
