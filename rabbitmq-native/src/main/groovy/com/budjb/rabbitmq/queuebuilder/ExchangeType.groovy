/*
 * Copyright 2013-2017 Bud Byrd
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
 */
package com.budjb.rabbitmq.queuebuilder

import org.slf4j.Logger
import org.slf4j.LoggerFactory

enum ExchangeType {
    /**
     * Fanout exchange.
     */
    FANOUT('fanout'),

    /**
     * Direct exchange.
     */
    DIRECT('direct'),

    /**
     * Topic exchange.
     */
    TOPIC('topic'),

    /**
     * Headers exchange.
     */
    HEADERS('headers'),

    /**
     * Consistent Hashing exchange.
     */
    XCONSISTENTHASH('x-consistent-hash')

    /**
     * The actual name to be used for the exchange type.
     */
    private final String realName

    /**
     * Constructor with real name.
     */
    private ExchangeType(String realName) {
        this.realName = realName
    }

    /**
     * Returns the real name of the exchange type.
     */
    String getRealName() {
        return this.realName
    }

    /**
     * Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(ExchangeType)

    /**
     * Returns the enum that matches the given value regardless of character case.
     *
     * If no match is found, null is returned.
     *
     * @param val The string value to look up.
     * @return The matching ExchangeType, or null if no match is found.
     */
    static ExchangeType lookup(String val) {
        if (val == null) {
            return null
        }

        // Find the matching ExchangeType
        ExchangeType foundType = values().find { it.realName.equalsIgnoreCase(val) }

        // If no matching type is found, log the error and return null
        if (foundType == null) {
            log.trace("No ExchangeType with name '${val}' found")
            return null
        }

        // Return the found ExchangeType
        return foundType
    }

}
