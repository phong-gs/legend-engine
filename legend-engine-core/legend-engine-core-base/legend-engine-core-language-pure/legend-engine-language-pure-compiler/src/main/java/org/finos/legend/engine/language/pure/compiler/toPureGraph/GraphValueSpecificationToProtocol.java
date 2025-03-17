// Copyright 2025 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.language.pure.compiler.toPureGraph;

import org.finos.legend.engine.protocol.pure.m3.valuespecification.constant.datatype.primitive.CInteger;
import org.finos.legend.pure.m3.coreinstance.meta.pure.metamodel.valuespecification.InstanceValue;
import org.finos.legend.pure.m3.coreinstance.meta.pure.metamodel.valuespecification.ValueSpecification;

public class GraphValueSpecificationToProtocol
{
    public static org.finos.legend.engine.protocol.pure.m3.valuespecification.ValueSpecification transform(ValueSpecification x)
    {
        if (x instanceof InstanceValue)
        {
            if (x._genericType()._rawType()._name().equals("Integer"))
            {
                Object value = ((InstanceValue) x)._values().getFirst();
                return new CInteger(value instanceof Integer ? (Integer) value : (long)value);
            }
        }
        throw new RuntimeException("Not implemented yet");
    }
}
