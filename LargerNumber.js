var largestNumber = function(nums) {
    nums.sort((a,b) => {
        a = a.toString();
        b = b.toString();
        return parseInt(b+a) - parseInt(a+b);
    })
    nums = nums.join("");
    return (nums == 0)? "0" : nums
};
