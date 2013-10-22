(ns bob
  (require [clojure.string :as str]))

(defn- silence?    [msg] (str/blank? msg))

(defn- question?   [msg] (= \? (last msg)))

(defn- has-letter? [msg] (some #(or (Character/isUpperCase %)
                                    (Character/isLowerCase %)) msg))

(defn- shouting?   [msg] (and (= msg (str/upper-case msg))
                              (has-letter? msg)))

(defn response-for [input]
  (cond
    ;; is the string empty?
    (str/blank? input) "Fine. Be that way!"
    ;; is the string uppercase and has a letter.
    (and (= input (str/upper-case input))(has-letter? input))  "Woah, chill out!"
    ;; is the last input a question mark?
    (= \? (last input)) "Sure."
    ;; everthing else falls to numbers
    :else "Whatever.")
    )
