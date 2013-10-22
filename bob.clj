(ns bob
  (require [clojure.string :as str]))

#has a letter or has a number

(defn- question? [msg] (= \? (last msg)))
(defn- has-letter? [msg] (some #(or (Character/isUpperCase %)
                                    (Character/isLowerCase %)) msg))

(defn- shouting? [msg] (and (= msg (str/upper-case msg))
                              (has-letter? msg)))

(defn response-for [input]
  (cond
    (str/blank? input) "Fine. Be that way!"
    (= input (str/upper-case input)) "Woah, chill out!"
    (= some #(Character/isUpperCase %) input)
    (= \? (last input)) "Sure."
    :else "Whatever.")
    )