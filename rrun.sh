#! /bin/bash
# Launch script for cs_eda016

# Function for determining wether classfiles should be run with junit
# and hamcrest. Also used to determine wether the folder is valid.
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
dir=../../bin/cs_edaa01
if [ -d $dir ]; then
	echo "$dir exists, proceeding ..."
else
	echo "$dir does't exist, please run install.sh ... "
	exit 0
fi

# Path to the junit and hamcrest .jars.
junit=/home/tfla/code/src/cs_edaa01/junit-4.11.jar:
hamcrest=/home/tfla/code/src/cs_edaa01/hamcrest-all-1.3.jar:

# Path to argument for lab06.
l6file=/home/tfla/test

# Array for projects that need junit and hamcrest to run.
jharr=("test" "testqueue" "testsort")

#Select what to run.
PS3='Choose a folder to use: '
select folder in $( ls $dir ); do
	# Array for valid folders.
	valid=("lab01" "lab02" "lab03" "lab04" "lab05" "lab06" "banktest" "övn02" "övn04" "tree")
	
	# Check that $dir is valid.
	if [[ $(contains "${valid[@]}" "${folder}") == "n" ]]; then
		echo "That's not a correct folder, exiting ..."
		break
	elif [[ $(contains "${valid[@]}" "${folder}") == "y" ]]; then
		
		# Select a package.
		PS4='Choose a package to use: '
		select pkg in $( ls $dir/$folder ); do

			# Select a classfile.
			PS5='Choose a file to run: '
			select classfile in $( ls $dir/$folder/$pkg ); do
				classfile=`echo $classfile | sed 's/\..\{5\}$//'`
				cd $dir/$folder/

				# Force lab06 to run with args.
				if [[ "${folder}" == "lab06" ]]; then
					java -Dswing.defaultlaf=com.sun.java.swing.plaf.gtk.GTKLookAndFeel "$pkg"."$classfile" "$l6file"
				fi

				# Check if junit and hamcrest are needed.
				if [[ $(contains "${jharr[@]}" "${pkg}") == "n" ]]; then
					java -Dswing.defaultlaf=com.sun.java.swing.plaf.gtk.GTKLookAndFeel "$pkg"."$classfile"
				elif [[ $(contains "${jharr[@]}" "${pkg}") == "y" ]]; then
					java -Dswing.defaultlaf=com.sun.java.swing.plaf.gtk.GTKLookAndFeel -cp "$junit""$hamcrest" org.junit.runner.JUnitCore "$pkg"."$classfile"
				fi
				break
			done
			break
		done
	fi
	break
done

exit 0
