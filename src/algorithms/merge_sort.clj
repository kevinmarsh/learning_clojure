(ns algorithms.merge-sort)

(defn split-middle [col]
  (split-at (/ (count col) 2) col))

(defn merge-seqs [left right]
  (loop [l left r right result []]
    (let [l1 (first l) r1 (first r)]
      (cond (empty? l) (concat result r)
            (empty? r) (concat result l)
            (>= l1 r1) (recur l (rest r) (conj result r1))
            :else      (recur r (rest l) (conj result l1))))))

(defn merge-sort [col]
  (if (> 2 (count col)) col
    (apply merge-seqs (map merge-sort (split-middle col)))))
