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

package org.apache.hadoop.hive.ql.exec.vector.expressions;

/**
 * Return Unix Timestamp.
 * Extends {@link VectorUDFTimestampFieldLong}
 */
public final class VectorUDFUnixTimeStampLong extends VectorUDFTimestampFieldLong {

  @Override
  protected long getField(long time) {
    long ms = time / (1000*1000);
    long remainder = time % (1000*1000);
    /* negative timestamps need to be adjusted */
    if(remainder < 0) {
      ms -= 1;
    }
    return ms/1000;
  }

  public VectorUDFUnixTimeStampLong(int colNum, int outputColumn) {
    /* not a real field */
    super(-1, colNum, outputColumn);
  }

}
