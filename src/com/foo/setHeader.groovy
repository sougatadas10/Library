package com.foo

class setHeader implements Serializable{

	String setShellHeader(String cmd) {
		return ("#!/bin/bash -e\n set +x\n"+cmd)
	}
}
