#!/bin/bash

set -x

RES=$(git show-ref --tags)
if [ -z "$RES" ]; then
    NEW_TAG="v1.0"
else
    LATEST_TAG=$(git tag | sort -V | tail -1)

    IFS='.' read -ra array <<< "$LATEST_TAG"
    for i in "${array[@]}"; do
      echo "$i"
    done

    one=${array[0]//v}
    two=${array[1]}

    if [ "$two" == "999" ]; then
	    two=0
      ((one++))
    else
      ((two++))
    fi

    NEW_TAG="v${one}.${two}"
    echo $NEW_TAG
fi

git tag $NEW_TAG
git push --tags
