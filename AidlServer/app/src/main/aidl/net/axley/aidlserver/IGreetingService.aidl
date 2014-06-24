// IGreetingService.aidl
package net.axley.aidlserver;

/**
 * Service interface for a binder.
 */
interface IGreetingService {
    /**
     * Returns a greeting message to the caller, personalized with @personName
     */
    String greet(String personName);
}
