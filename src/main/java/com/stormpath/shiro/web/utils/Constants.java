/*
 * Copyright 2014 Stormpath, Inc.
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
package com.stormpath.shiro.web.utils;

import com.stormpath.sdk.lang.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

    private static final Map<String, String> messagesMap = new HashMap<String, String>();

    public static final String MESSAGE_FLAG = "source";

    public static final String REGISTRATION_ERROR_FLAG = "registrationError";
    public static final String GOOGLE_LOGIN_ERROR = "googleError";
    public static final String GOOGLE_LOGIN_ERROR_MSG = "There was an error granting access to this application with the given Google user.";
    public static final String FACEBOOK_LOGIN_ERROR = "facebookError";
    public static final String FACEBOOK_LOGIN_ERROR_MSG = "There was an error granting access to this application with the given Facebook user.";

    static {
        messagesMap.put(GOOGLE_LOGIN_ERROR, GOOGLE_LOGIN_ERROR_MSG);
        messagesMap.put(FACEBOOK_LOGIN_ERROR, FACEBOOK_LOGIN_ERROR_MSG);
    }

    public static String getMessage(String key) {
        String message = messagesMap.get(key);
        if(Strings.hasText(message)) {
            return message;
        }

        logger.warn("No message could be found for " + key + " in constants map.");
        return "";
    }

}
