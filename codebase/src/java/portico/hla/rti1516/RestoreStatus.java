/*
 *   This file is provided as a copy from the SISO (http://www.sisostds.org) DLC standard for
 *   HLA 1516 (SISO-STD-004.1-2004).
 * 
 *   THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED
 *   WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *   OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED.  IN NO EVENT SHALL THE DEVELOPERS OF THIS PROJECT OR
 *   ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *   SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *   LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 *   USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 *   OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 *   OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 *   SUCH DAMAGE.
 *
 *   Use of this software is strictly AT YOUR OWN RISK!!!
 *   If something bad happens you do not have permission to come crying to me.
 *   (that goes for your lawyer as well)
 */
package hla.rti1516;

public final class RestoreStatus implements java.io.Serializable
{
	private static final long serialVersionUID = 98121116105109L;
	
	private int _value; //each instance's value 

	private static final int _lowestValue = 1;

	private static int _nextToAssign = _lowestValue; //begins at lowest 

	/** 
	 This is the only public constructor. Each user-defined instance of a 
	 RestoreStatus 
	 must be initialized with one of the defined static values. 
	 * @param otherRestoreStatusValue must be a defined static value or another 
	 instance. 
	 */
	public RestoreStatus( RestoreStatus otherRestoreStatusValue )
	{
		_value = otherRestoreStatusValue._value;
	}

	/** 
	 Private to class 
	 */
	private RestoreStatus()
	{
		_value = _nextToAssign++;
	}

	RestoreStatus( int value ) throws RTIinternalError
	{
		_value = value;
		if( value < _lowestValue || value >= _nextToAssign )
			throw new RTIinternalError( "RestoreStatus: illegal value " + value );
	}

	/** 
	 * @return String with value "RestoreStatus(n)" where n is value 
	 */
	public String toString()
	{
		return "RestoreStatus(" + _value + ")";
	}

	/** 
	 Allows comparison with other instance of same type. 
	 * @return true if supplied object is of type RestoreStatus and has same 
	 value; 
	 false otherwise 
	 */
	public boolean equals( Object otherRestoreStatusValue )
	{
		if( otherRestoreStatusValue instanceof RestoreStatus )
			return _value == ((RestoreStatus)otherRestoreStatusValue)._value;
		else
			return false;
	}

	public int hashCode()
	{
		return _value;
	}

	static public final RestoreStatus NO_RESTORE_IN_PROGRESS = new RestoreStatus();

	static public final RestoreStatus FEDERATE_RESTORE_REQUEST_PENDING = new RestoreStatus();

	static public final RestoreStatus FEDERATE_WAITING_FOR_RESTORE_TO_BEGIN = new RestoreStatus();

	static public final RestoreStatus FEDERATE_PREPARED_TO_RESTORE = new RestoreStatus();

	static public final RestoreStatus FEDERATE_RESTORING = new RestoreStatus();

	static public final RestoreStatus FEDERATE_WAITING_FOR_FEDERATION_TO_RESTORE =
	    new RestoreStatus();
} 

