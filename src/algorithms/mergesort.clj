(ns algorithms.mergesort)
;; Merge sort algorithm, the key piece is the merge functionality

(defn split [col]
  (split-at (/ (count col) 2) col))

(defn mysort [col]
  ;; Let's just cheat for now
  (sort col))

(defn mymerge-iter [x y result]
  (if (empty? x)
    (if (empty? y)
      result
      (recur x (rest y) (conj result (first y))))
    (if (empty? y)
      (recur (rest x) y (conj result (first x)))
      (if (< (first x) (first y))
        (recur (rest x) y (conj result (first x)))
        (recur x (rest y) (conj result (first y)))))))

(defn mymerge [x y]
  (mymerge-iter x y []))

(defn mergesort [col]
  (apply mymerge (map mysort (split col))))