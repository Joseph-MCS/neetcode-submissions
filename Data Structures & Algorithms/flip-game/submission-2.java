class Solution {
    public List<String> generatePossibleNextMoves(String currentState){

        List<String> res = new ArrayList<>();
        for ( int i = 0; i<currentState.length() - 1; i++ )
        {
            if ( currentState.substring(i,i+2).equals("++"))
            {
                StringBuilder sb = new StringBuilder();
                sb.append(currentState.substring(0,i));
                sb.append("--");
                sb.append(currentState.substring(i+2,currentState.length()));
                res.add(sb.toString());
            }
        }       

        return res;
        }
}
