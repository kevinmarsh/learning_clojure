(ns algorithms.mergesort)
;; Merge sort algorithm, the key piece is the merge functionality

(defn split-middle [col]
  (split-at (/ (count col) 2) col))

(defn mysort [col]
  ;; Let's just cheat for now
  (sort col))

(defn mymerge-iter [x y result]
  (let [x1 (first x)
        y1 (first y)]
    (cond
      (every? nil? [x1 y1]) result
      (or (nil? x1)
          (and (not (nil? y1))
               (> x1 y1))) (recur x (rest y) (conj result (first y)))
      :else (recur (rest x) y (conj result (first x))))))

(defn mymerge [x y]
  (mymerge-iter x y []))

(defn mergesort [col]
  (apply mymerge (map mysort (split-middle col))))