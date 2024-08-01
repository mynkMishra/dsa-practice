public class Solution {
    public int CountSeniors(string[] details) {

        return details
                .Where(d => Int32.Parse(d.Substring(11,2)) > 60) 
                .ToList().Count();
    }
}