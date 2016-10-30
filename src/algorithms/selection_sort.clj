(ns algorithms.selection-sort)

(defn get-min-index [col]
  (let [ennumerated (map vector col (range))]
    (last (apply min-key first ennumerated))))

(defn drop-nth [n col]
  (concat (take n col) (drop (inc n) col)))

(defn selection-sort [col]
  (loop [input (into [] col) output []]
    (if (empty? input) output
        (let [min-pos (get-min-index input)]
          (recur (drop-nth min-pos input) (conj output (nth input min-pos)))))))
