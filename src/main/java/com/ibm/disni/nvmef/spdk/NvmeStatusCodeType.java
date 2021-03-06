/*
 * DiSNI: Direct Storage and Networking Interface
 *
 * Author: Jonas Pfefferle <jpf@zurich.ibm.com>
 *
 * Copyright (C) 2016, IBM Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ibm.disni.nvmef.spdk;

public enum NvmeStatusCodeType {
	GENERIC(0x0),
	COMMAND_SPECIFIC(0x1),
	MEDIA_ERROR(0x2),
	VENDOR_SPECIFIC(0x7);

	private int numVal;

	NvmeStatusCodeType(int numVal) { this.numVal = numVal; }

	static NvmeStatusCodeType valueOf(int numVal) {
		for (NvmeStatusCodeType statusCodeType : NvmeStatusCodeType.values()) {
			if (numVal == statusCodeType.getNumVal()) {
				return statusCodeType;
			}
		}
		throw new IllegalArgumentException();
	}

	int getNumVal() { return numVal; }
}
