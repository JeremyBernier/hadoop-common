/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.plan;

import java.io.Serializable;

import org.apache.hadoop.hive.ql.typeinfo.TypeInfo;

public class exprNodeFieldDesc extends exprNodeDesc implements Serializable {
  private static final long serialVersionUID = 1L;
  exprNodeDesc desc;
  String fieldName;
  
  public exprNodeFieldDesc() {}
  public exprNodeFieldDesc(TypeInfo typeInfo, exprNodeDesc desc, String fieldName) {
    super(typeInfo);
    this.desc = desc;
    this.fieldName = fieldName;    
  }
  
  public exprNodeDesc getDesc() {
    return this.desc;
  }
  public void setDesc(exprNodeDesc desc) {
    this.desc = desc;
  }
  public String getFieldName() {
    return this.fieldName;
  }
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }
  @Override
  public String toString() {
    return this.desc.toString() + "." + this.fieldName;
  }
  
  @explain(displayName="expr")
  @Override
  public String getExprString() {
    return this.desc.getExprString() + "." + this.fieldName;
  }
}
