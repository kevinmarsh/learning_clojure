(ns fourclojure.pascals-triangle)

;; http://www.4clojure.com/problem/97
;; Pascal's triangle is a triangle of numbers computed using the following rules:
;;   - The first row is 1.
;;   - Each successive row is computed by adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.
;; Write a function which returns the nth row of Pascal's Triangle.

(defn pascals-triangle [n]
  (loop [counter 0
         n_rows n
         prev_row []]
    (if (> counter n_rows)
        prev_row
        (let [curr_row
              (if (= counter 1)
                  [1]
                  (concat [1] (map + prev_row (rest prev_row)) [1]))]
          (recur (inc counter) n_rows curr_row)))))

;; Wow looking at cgrand's 4clojure solution, amazingingly concise

(fn [n]
  (nth (iterate #(concat [1] (map + % (next %)) [1]) [1]) (dec n)))