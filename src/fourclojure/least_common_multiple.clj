(ns fourclojure.least-common-multiple)

;; http://www.4clojure.com/problem/100

;; This works for integers, not for fractions
(defn is-multiple? [x y]
  (= (rem x y) 0))

(defn is-multiple-of-all? [col x]
  (every? (partial is-multiple? x) col))

(defn simple-least-common-multiple [& args]
  (first (filter (partial is-multiple-of-all? args) (rest (range)))))

;; Turned into a one liner for 4clojure

#(first (filter
          (partial (fn [col x] (every?
                                 (partial (fn [a b] (= (rem a b) 0)) x)
                                 col)) %&)
          (rest (range))))

;; Refactored through reduction by the greatest common divisor
;; https://en.wikipedia.org/wiki/Least_common_multiple#Reduction_by_the_greatest_common_divisor

(defn greatest-common-divisor [a b]
  (if (= b 0)
    a
    (recur b (mod a b))))

(defn pair-least-common-multiple [a b]
  (/ (* a b) (greatest-common-divisor a b)))

(defn least-common-multiple [& args]
  (reduce pair-least-common-multiple args))

;; Turned into a one liner for 4clojure

(fn [& args]
  (let [gcd (fn gcd [a b] (if (= b 0) a (gcd b (mod a b))))
        lcm (fn lcm [a b] (/ (* a b) (gcd a b)))]
    (reduce lcm args)))