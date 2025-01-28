// Copyright 2022 Goldman Sachs
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

package org.finos.legend.engine.query.graphQL.api.format.generation;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.list.MutableList;
import org.finos.legend.engine.external.shared.format.extension.GenerationExtension;
import org.finos.legend.engine.external.shared.format.extension.GenerationMode;
import org.finos.legend.engine.external.shared.format.generations.description.FileGenerationDescription;
import org.finos.legend.engine.external.shared.format.generations.description.GenerationConfigurationDescription;
import org.finos.legend.engine.external.shared.format.generations.description.GenerationProperty;
import org.finos.legend.engine.language.pure.compiler.toPureGraph.CompileContext;
import org.finos.legend.engine.language.pure.compiler.toPureGraph.PureModel;
import org.finos.legend.engine.protocol.pure.m3.PackageableElement;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.fileGeneration.FileGenerationSpecification;
import org.finos.legend.pure.generated.Root_meta_pure_generation_metamodel_GenerationConfiguration;
import org.finos.legend.pure.generated.Root_meta_pure_generation_metamodel_GenerationOutput;
import org.finos.legend.pure.generated.core_external_query_graphql_deprecated_generation;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class GraphQLGenerationExtension implements GenerationExtension
{
    @Override
    public MutableList<String> group()
    {
        return org.eclipse.collections.impl.factory.Lists.mutable.with("Query", "GraphQL");
    }

    @Override
    public String type()
    {
        return "Generation - To Delete?";
    }

    @Override
    public String getLabel()
    {
        return "GraphQL";
    }

    @Override
    public String getKey()
    {
        return "graphql";
    }

    @Override
    public GenerationMode getMode()
    {
        return GenerationMode.Schema;
    }

    @Override
    public GenerationConfigurationDescription getGenerationDescription()
    {
        return new GenerationConfigurationDescription()
        {
            @Override
            public String getLabel()
            {
                return GraphQLGenerationExtension.this.getLabel();
            }

            @Override
            public String getKey()
            {
                return GraphQLGenerationExtension.this.getKey();
            }

            @Override
            public List<GenerationProperty> getProperties(PureModel pureModel)
            {
                return FileGenerationDescription.extractGenerationProperties(core_external_query_graphql_deprecated_generation.Root_meta_external_query_graphQL_generation_describeConfiguration__GenerationParameter_MANY_(pureModel.getExecutionSupport()));
            }
        };
    }

    @Override
    public Root_meta_pure_generation_metamodel_GenerationConfiguration defaultConfig(CompileContext context)
    {
        return core_external_query_graphql_deprecated_generation.Root_meta_external_query_graphQL_generation_defaultConfig__GraphQLConfig_1_(context.pureModel.getExecutionSupport());
    }

    @Override
    public List<Root_meta_pure_generation_metamodel_GenerationOutput> generateFromElement(PackageableElement element, CompileContext context)
    {
        if (element instanceof FileGenerationSpecification)
        {
            FileGenerationSpecification specification = (FileGenerationSpecification) element;
            GraphQLGenerationConfig graphQLGenerationConfig = GraphQLGenerationConfigFromFileGenerationSpecificationBuilder.build(specification);
            RichIterable<? extends Root_meta_pure_generation_metamodel_GenerationOutput> output =
                    core_external_query_graphql_deprecated_generation.Root_meta_external_query_graphQL_generation_generateGraphQL_GraphQLConfig_1__GraphQLOutput_MANY_(graphQLGenerationConfig.process(context.pureModel), context.pureModel.getExecutionSupport());
            return new ArrayList<>(output.toList());
        }
        return null;
    }
}
