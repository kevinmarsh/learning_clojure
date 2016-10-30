(ns algorithms.binary-search
  (:require [clojure.math.numeric-tower :as math]))

(defn int-average [& numbers]
  (int (/ (apply + numbers) (count numbers))))

(defn binary-search [col item]
  (loop [low 0
         high (dec (count col))]
    (let [med (int-average low high)
          guess (get col med)]
      (cond (= guess item) med
            (<= high low) nil
            (> guess item) (recur low (dec med))
            :else (recur (inc med) high)))))
