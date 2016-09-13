(ns exercism.phone-number)

; Write a program that cleans up user-entered phone numbers so that they can be sent SMS messages.
; The rules are as follows:
;   * If the phone number is less than 10 digits assume that it is bad number
;   * If the phone number is 10 digits assume that it is good
;   * If the phone number is 11 digits and the first number is 1, trim the 1 and use the last 10 digits
;   * If the phone number is 11 digits and the first number is not 1, then it is a bad number
;   * If the phone number is more than 11 digits assume that it is a bad number


(def join-str (partial clojure.string/join ""))

(def bad-number (join-str (take 10 (repeat "0"))))

(defn number [n]
  (let [numbers (filter (partial re-matches #"\d") (map str n))
        n_numbers (count numbers)]
  (cond
    (or (< n_numbers 10) (> n_numbers 11)) bad-number
    (= n_numbers 11) (if (= (first numbers) "1")
                       (join-str (rest numbers))
                       bad-number)
    :default (join-str numbers))))

(defn area-code [n]
  (subs (number n) 0 3))

(defn pretty-print [n]
  (let [numb (number n)
        area-code (subs numb 0 3)
        beg (subs numb 3 6)
        end (subs numb 6)]
    (str "(" area-code ") " beg "-" end)))
