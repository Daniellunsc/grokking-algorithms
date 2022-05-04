(defn binary-search [initial-ordered-list initial-target]
  (loop [ordered-list initial-ordered-list
         target        initial-target
         index-shifter 0]
    (let [index        (-> ordered-list count (/ 2) int)
          middle-value (get ordered-list index)
          final-index  (count ordered-list)]
        (cond
         (empty? ordered-list)  nil
         (> middle-value target) (recur (subvec ordered-list 0 index) target index-shifter)
         (< middle-value target) (recur (subvec ordered-list (inc index) final-index) target (+ index-shifter index 1))
         (= middle-value target) (+ index-shifter index)))))

;; test case:
(binary-search [1 2 3 4 5] 1)
