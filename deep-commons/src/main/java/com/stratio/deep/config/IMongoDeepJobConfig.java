/*
 * Copyright 2014, Stratio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stratio.deep.config;

import com.mongodb.QueryBuilder;
import org.apache.hadoop.conf.Configuration;
import org.bson.BSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Defines the public methods that each Stratio Deep MongoDB configuration object should implement.
 */
public interface IMongoDeepJobConfig<T> extends IDeepJobConfig<T, IMongoDeepJobConfig<T>> {
    /**
     * The MongoDB's collection name
     */
    public abstract IMongoDeepJobConfig<T> collection(String collection);

    /**
     * The MongoDB's database name
     */
    public abstract IMongoDeepJobConfig<T> database(String database);

    /**
     * Sets the list of available Mongo hosts.
     * @param host the list of available mongo hosts.
     * @return this object.
     */
    public abstract IMongoDeepJobConfig<T> host(List<String> host);

    /**
     * The replica set identifier.
     */
    public abstract IMongoDeepJobConfig<T> replicaSet(String replicaSet);

    /**
     * @return the hadoop configuration object if the concrete implementation has one, null otherwise.
     */
    public abstract Configuration getHadoopConfiguration();

    /**
     * Configures the 'readPreference' MongoDB's config property.
     *
     * @param readPreference the property value to set.
     * @return this object.
     */
    public abstract IMongoDeepJobConfig<T> readPreference(String readPreference);

    /**
     *Filter query
     * @param query
     * @return
     */
    public IMongoDeepJobConfig<T> filterQuery(String query);

    /**
     *Filter query
     * @param query
     * @return
     */
    public IMongoDeepJobConfig<T> filterQuery(BSONObject query);

    /**
     *Filter query
     * @param query
     * @return
     */
    public IMongoDeepJobConfig<T> filterQuery(QueryBuilder query);

    /**
     *Fiels to be returned
     * @param fields
     * @return
     */
    public IMongoDeepJobConfig<T> fields(String fields);


    /**
     * Fiels to be returned
     * @param fields
     * @return
     */
    public IMongoDeepJobConfig<T> fields(BSONObject fields);

    /**
     * Sorting
     * @param sort
     * @return
     */
    public IMongoDeepJobConfig<T> sort(String sort);

    /**
     * Sorting
     * @param sort
     * @return
     */
    public IMongoDeepJobConfig<T> sort(BSONObject sort);

    /**
     *  This is {@code true} by default now, but if {@code false}, only one InputSplit (your whole collection) will be
     * assigned to Spark – severely reducing parallel mapping.
     *
     * @param createInputSplit
     * @return
     */
    public IMongoDeepJobConfig<T> createInputSplit(boolean createInputSplit);

    /**
     *
     * If {@code true} in a sharded setup splits will be made to connect to individual backend {@code mongod}s.  This
     * can be unsafe. If {@code mongos} is moving chunks around you might see duplicate data, or miss some data
     * entirely. Defaults to {@code false}
     *
     * @param useShards
     * @return
     */
    public IMongoDeepJobConfig<T> useShards(boolean useShards);


    /**
     * If {@code true} have one split = one shard chunk.  If {SPLITS_USE_SHARDS} is not true splits will still
     * use chunks, but will connect through {@code mongos} instead of the individual backend {@code mongod}s (the safe
     * thing to do). If {SPLITS_USE_SHARDS} is {@code true} but this is {@code false} one split will be made for
     * each backend shard. THIS IS UNSAFE and may result in data being run multiple times <p> Defaults to {@code true }
     *
     * @param splitsUseChunks
     * @return
     */
    public IMongoDeepJobConfig<T> splitsUseChunks(boolean splitsUseChunks);

    /**
     *
     * @param inputKey
     * @return
     */
    public IMongoDeepJobConfig<T> inputKey(String inputKey);
}